package Exception;

import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.IMessageContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import sun.plugin2.message.Message;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException {

    private static final long serialVersionUID = 1L;

   /* public ResourceNotFoundException(String message){
        super(message);
    }*/
}
