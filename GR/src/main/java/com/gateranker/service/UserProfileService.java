package com.gateranker.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author Sap Dharma Satyam
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface UserProfileService {

}
