package com.example.qsl.user.repository;

import com.example.qsl.user.entity.SiteUser;

public interface UserRepositoryCustom {
    SiteUser getQslUser(Long id);
}
