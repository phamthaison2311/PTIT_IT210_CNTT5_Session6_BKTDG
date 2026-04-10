package com.bkt.config;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInt extends AbstractAnnotationConfigDispatcherServletInitializer

     {
         @Nullable
         @Override
         protected Class<?>[] getRootConfigClasses() {
             return new Class[0];
         }

         @Nullable
         @Override
         protected Class<?>[] getServletConfigClasses() {
             return new Class[]{WebConfig.class};
         }

         @Override
         protected String[] getServletMappings() {
             return new String[]{"/"};
         }
     }
