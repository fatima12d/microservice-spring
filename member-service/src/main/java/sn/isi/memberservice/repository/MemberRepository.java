package sn.isi.memberservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.memberservice.entity.Member;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);

}
