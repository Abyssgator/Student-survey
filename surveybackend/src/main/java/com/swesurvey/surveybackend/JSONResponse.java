/* 
<!-- Team Members
 Name: Ashrith Bhooka Ravinandan
 Gno. G01455956

 Name:Rishith Reddy Pendli
 Gno. G01411978

 Name: Sathwik Reddy Bojja
 Gno. G01461462 
 
 This file sends the response messages to the frontend while making api calls
 -->
*/

package com.swesurvey.surveybackend;

public class JSONResponse {
    private String message;

    public JSONResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
