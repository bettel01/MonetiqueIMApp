package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.InterfaceT;

public interface InterfaceRepository extends JpaRepository<InterfaceT, Integer>{

}
