package com.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.EnquiryDetails;
@Repository
public interface OperationExecutiveRepositary extends JpaRepository<EnquiryDetails, Integer> {

}
