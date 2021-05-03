package com.kafkademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafkademo.ProjectDetails;

public interface KafkaProdRepository extends JpaRepository<ProjectDetails, Integer> {

}
