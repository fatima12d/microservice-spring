package sn.isi.loanservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.loanservice.entity.Loan;
import sn.isi.loanservice.entity.LoanStatus;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    List<Loan> findByMemberId(Integer memberId);
    List<Loan> findByBookId(Integer bookId);
    List<Loan> findByStatus(LoanStatus status);
    boolean existsByBookIdAndStatus(Integer bookId, LoanStatus status);

}
