package com.portal.config;

import com.portal.dto.request.AddProjectRequest;
import com.portal.entity.Customer;
import com.portal.entity.Project;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    private static final Converter<AddProjectRequest, Project> ADD_PROJECT_REQUEST_PROJECT_CONVERTER =
            mappingContext -> Project.builder()
                    .projectName(mappingContext.getSource().getProjectName())
                    .status(mappingContext.getSource().getStatus())
                    .offer(mappingContext.getSource().getOffer())
                    .startDate(mappingContext.getSource().getStartDate())
                    .endDate(mappingContext.getSource().getEndDate())
                    .customer(Customer.builder()
                            .fullname(mappingContext.getSource().getCustomerRequest().getFullname())
                            .mail(mappingContext.getSource().getCustomerRequest().getMail())
                            .phone(mappingContext.getSource().getCustomerRequest().getPhone())
                            .build())
                    .build();

    @Bean
    ModelMapper modelMapper(){
        var modelMapper = new ModelMapper();
            modelMapper.addConverter(ADD_PROJECT_REQUEST_PROJECT_CONVERTER,AddProjectRequest.class,Project.class);
        return modelMapper;
    }
}
