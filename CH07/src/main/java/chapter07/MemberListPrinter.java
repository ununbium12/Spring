package chapter07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

public class MemberListPrinter {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    @Qualifier("memberPrinter")
    private MemberPrinter memberPrinter;


    public void printAll() {
        // 현재까지 등록된 전체 맴버리스트
        Collection<Member> members = memberDao.selectAll();
        members.forEach(member -> memberPrinter.print(member));
    }
}
