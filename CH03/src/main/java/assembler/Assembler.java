package assembler;

import chapter03.ChangePasswordService;
import chapter03.MemberDao;
import chapter03.MemberRegisterService;

public class Assembler {

    private MemberDao memberDao;
    private MemberRegisterService memberRegisterService;
    private ChangePasswordService changePasswordService;

    // 실행시킬때 지금까지 생성된 서버를 하나의 클래스에서 관리하기 위해서 Assembler class를 만든 것이다.
    public Assembler() {
        memberDao = new MemberDao();
        memberRegisterService = new MemberRegisterService(memberDao);
        changePasswordService = new ChangePasswordService();
        changePasswordService.setMemberDao(memberDao);
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public MemberRegisterService getMemberRegisterService() {
        return memberRegisterService;
    }

    public ChangePasswordService getChangePasswordService() {
        return changePasswordService;
    }
}