package com.example.qsl.interestKeyword.entity;

import com.example.qsl.user.entity.SiteUser;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InterestKeyword {
    @Id
    @EqualsAndHashCode.Include
    private String content;


}
