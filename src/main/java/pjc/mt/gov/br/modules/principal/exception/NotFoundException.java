package pjc.mt.gov.br.modules.principal.exception;

public class NotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NotFoundException(String message){
            super(message);
    }
}
