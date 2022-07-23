package com.example.mys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mys.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

}
