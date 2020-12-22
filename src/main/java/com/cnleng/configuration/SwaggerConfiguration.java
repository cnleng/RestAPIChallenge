package com.cnleng.configuration;

//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;

//@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {
    private static final String API_DESCRIPTION = "BookIt service is a RESTful API that provides users with out of the box functionnality to manage bookings";

    /**
     *
     */
    public SwaggerConfiguration() {
    }

//    @Bean
//    public LinkDiscoverers discoverers() {
//        List<JsonPathLinkDiscoverer> plugins = new ArrayList<>();
//        plugins.add(new HalLinkDiscoverer());
//        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
//    }
//
//    @Bean
//    public LinkRelationProvider provider() {
//        return new EvoInflectorLinkRelationProvider();
//    }
//
//    @Bean
//    @Primary
//    public PluginRegistryFactoryBean<LinkRelationProvider, LinkRelationProvider.LookupContext>
//    myPluginRegistryProvider(){
//
//        PluginRegistryFactoryBean<LinkRelationProvider, LinkRelationProvider.LookupContext> factory
//                = new PluginRegistryFactoryBean<>();
//
//        factory.setType(LinkRelationProvider.class);
//        Class<?> classes[] = new Class<?>[1];
//        classes[0] = DelegatingLinkRelationProvider.class;
//        factory.setExclusions(classes);
//
//        return factory;
//    }
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any()).build().enable(true).apiInfo(apiInfo());
//    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Overview")
//                .description(API_DESCRIPTION)
//                .termsOfServiceUrl("http://springfox.io")
//                .contact(new Contact("Cyril Nleng", null, "hencyr@hotmail.com"))
////	            .license("Apache License Version 2.0")
////	            .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
//                .version("0.0.1")
//                .build();
//    }
}
