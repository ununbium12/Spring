package main;

import assembler.Assembler;
import chapter03.ChangePasswordService;
import chapter03.DuplicationMemberException;
import chapter03.MemberNotFoundException;
import chapter03.MemberRegisterService;
import chapter03.RegisterRequest;
import chapter03.WrongPasswordException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class MainForAssembler {

    private static Assembler assembler = new Assembler();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("명령어를 입력하세요.");
            String command = reader.readLine();
            if(command.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다.");
                break;
            }
            if(command.startsWith("new")) {
                processNewCommand(command.split(" "));
                continue;
            } else if(command.startsWith("change")) {
                processChangeCommand(command.split(" "));
                continue;
            }
            printHelp();
        }
    }

    private static void processNewCommand(String[] arg) {
        if(arg.length != 5) {
            printHelp();
            return;
        }

        MemberRegisterService memberRegisterService = assembler.getMemberRegisterService();
        // {new, 이메일, 이름, 비밀번호, 비밀번호 확인}
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        if(!req.isPasswordEqualToConfirmPassword()) {
            System.out.println("암호와 확인이 일치하지 않습니다.");
            return;
        }

        try {
            memberRegisterService.regist(req);
            System.out.println("등록완료!");
        } catch (DuplicationMemberException e) {
            System.err.println("이미 존재하는 이메일입니다.");
        }
    }

    private static void processChangeCommand(String[] arg) {
        if(arg.length != 4) {
            printHelp();
            return;
        }
        // change email oldPassword 
        ChangePasswordService changePasswordService = assembler.getChangePasswordService();
        try {
            changePasswordService.changePassword(arg[1], arg[2], arg[3]);
            System.out.println("암호를 변경했습니다.");
        } catch (MemberNotFoundException e) {
            System.err.println("존재하지 않는 이메일입니다.");
        } catch (WrongPasswordException e) {
            System.err.println("이메일과 암호가 일치하지 않습니다.");
        }
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
        System.out.println("new 이메일 이름 암호 암호확인");
        System.out.println("change 이메일 현재암호 변경암호");
        System.out.println();
    }
}