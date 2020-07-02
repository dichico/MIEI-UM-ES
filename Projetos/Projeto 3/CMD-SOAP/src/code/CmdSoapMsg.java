package code;

import wsdlservice.CCMovelDigitalSignature;
import wsdlservice.CCMovelSignature;

public class CmdSoapMsg {

    CCMovelDigitalSignature service = new CCMovelDigitalSignature();

    CCMovelSignature connector = service.getBasicHttpBindingCCMovelSignature();

    public String getCertificate(byte[] applicationId, String meuTelemovel) {
        return connector.getCertificate(applicationId, meuTelemovel);
    }
}
