package chapter03;

public class MemberInfoPrinter {

    // 메서드명 : printMemberInfo
    // 매개변수 : 이메일
    // 동작 1. 이메일로 등록된 멤버인지 검증, 등록되지 않으면 데이터 없다고 출력
    // 동작 2. 멤버가 존제하면 memberPrinter.print(member)

    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            System.out.println("데이터 없음\n");
            return;
        }
        memberPrinter.print(member);
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void setMemberPrinter(MemberPrinter memberPrinter) {
        this.memberPrinter = memberPrinter;
    }

}
