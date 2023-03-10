package chapter03;

import java.time.LocalDateTime;

public class MemberRegisterService {

    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
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