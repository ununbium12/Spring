package chapter03;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class MemberRegisterService {

    @Autowired
    private MemberDao memberDao;

    // 만약 생성자가 없었다면, 아래쪽 memberDao 부분에는 null이 들어가고 만다.
    // Dao의 형식이 바뀌었을때 교체하면서 난잡해질 수 있기 때문에 의존형 Dao를 사용해서 생성자를 통해 쉽게 교체할 수 있게하는 것이다.
    public MemberRegisterService() {
    }

    public void regist(RegisterRequest req) {
        // 이메일로 회원 데이터 조회
        Member member = memberDao.selectByEmail(req.getEmail());
        if(member != null) {
            // 이미 같은 이메일 가진 회원이 존재
            throw new DuplicationMemberException("Duplication Email : "+ req.getEmail());
        }

        Member newMem = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
        memberDao.insert(newMem);
    }

}