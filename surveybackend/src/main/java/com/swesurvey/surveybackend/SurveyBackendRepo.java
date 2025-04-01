/* 
<!-- Team Members
 Name: Ashrith Bhooka Ravinandan
 Gno. G01455956

 Name:Rishith Reddy Pendli
 Gno. G01411978

 Name: Sathwik Reddy Bojja
 Gno. G01461462 
 
 This file is used to connect database to the file SurveyModel.java
  -->
*/

package com.swesurvey.surveybackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyBackendRepo extends JpaRepository<SurveyModel, Long> {
    
}
