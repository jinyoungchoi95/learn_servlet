package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepsoitoryTest {

    MemberRepsoitory memberRepsoitory = MemberRepsoitory.getInstance();

    @AfterEach
    void afterEach() {
        memberRepsoitory.clearStroe();
    }

    @Test
    void save() {

        //given
        Member member = new Member("hello", 20);

        //when
        Member savedMember = memberRepsoitory.save(member);

        //then
        Member findMember = memberRepsoitory.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {

        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepsoitory.save(member1);
        memberRepsoitory.save(member2);

        //when
        List<Member> result = memberRepsoitory.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}