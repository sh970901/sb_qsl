package com.example.qsl.user.repository;

import com.example.qsl.user.entity.SiteUser;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface UserRepositoryCustom {
    SiteUser getQslUser(Long id);
    public long getQslCount();

    SiteUser getQslUserOrderByIdAscOne();

    List<SiteUser> getQslUserOrderByIdAsc();

    List<SiteUser> searchQsl(String user1);

    Page<SiteUser> searchQsl(String user1, org.springframework.data.domain.Pageable pageable);

    List<SiteUser> getQsUserByInterestKeyword(String keywordContent);
}
