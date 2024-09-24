package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class CookHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Cook>> {

    @Override
    public EntityModel<Cook> process(EntityModel<Cook> model) {
        return model;
    }
}
