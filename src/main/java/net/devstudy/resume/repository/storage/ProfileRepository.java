package net.devstudy.resume.repository.storage;

import net.devstudy.resume.entity.Profile;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfileRepository extends PagingAndSortingRepository<Profile, Long> {
    Profile findByUid(String uid);




}
