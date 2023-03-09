package com.example.vijuserver.repository;

import com.example.vijuserver.model.VideogamePlatform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VideogamePlatformRepository extends JpaRepository<VideogamePlatform, Long>, JpaSpecificationExecutor<VideogamePlatform> {
}
