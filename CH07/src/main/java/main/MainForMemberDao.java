package main;

import chapter07.ChangePasswordService;
import chapter07.Member;
import chapter07.MemberDao;
import config.AppConfig;
import db.DbQuery;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainForMemberDao {

    private static MemberDao memberDao;

    private static ChangePasswordService changePasswordService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        memberDao = ctx.getBean("memberDao", MemberDao.class);
        changePasswordService = ctx.getBean("changePasswordService", ChangePasswordService.class);

        selectAll();
//        update();
        insert();
        selectAll();
//        Member member = memberDao.selectByEmail("a@a.com");
//        System.out.println(member.getId()+","+ member.getEmail()+","+ member.getName());
    }

    public static void selectAll() {
        int count = memberDao.count();
        System.out.println("count : "+count);
        List<Member> memberList = memberDao.selectAll();
        for(Member member : memberList) {
            System.out.println(member.getId()+","+ member.getEmail()+","+ member.getName());
        }
    }

    public static void update() {
        Member member = memberDao.selectByEmail("a@a.com");
        String oldPassword = member.getPassword();
        String newPassword = Double.toHexString(Math.random());
        changePasswordService.changePassword("a@a.com");
//         member.changePassword(oldPassword, newPassword);
        memberDao.update(member);
        System.out.println("ChangePassword : " + oldPassword + " -> " + newPassword);
    }

    private static DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("MMddHHmmss");

    public static void insert() {
        String prefix = formatter.format(LocalDateTime.now());
        Member member = new Member(prefix+"@test.com", prefix, prefix, LocalDateTime.now());
        memberDao.insert(member);
        System.out.println("Insert Mamber >>> " + member.getName() + ", " + member.getId());
    }
}
