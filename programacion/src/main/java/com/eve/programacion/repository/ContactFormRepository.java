
package com.eve.programacion.repository;

import com.eve.programacion.entity.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactFormRepository extends JpaRepository<ContactForm, Long> {
    
}
