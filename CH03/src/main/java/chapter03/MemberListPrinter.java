package chapter03;

import java.util.Collection;

public class MemberListPrinter {

    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
        this.memberDao = memberDao;
        this.memberPrinter = memberPrinter;
    }

    public void printAll() {
        // 현재까지 등록된 전체 맴버리스트
        Collection<Member> members = memberDao.selectAll();
        members.forEach(member -> memberPrinter.print(member));
    }
}
