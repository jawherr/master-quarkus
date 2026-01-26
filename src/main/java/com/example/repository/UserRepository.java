package com.example.repository;

import jakarta.enterprise.context.ApplicationScoped;

import javax.management.loading.ClassLoaderRepository;

@ApplicationScoped
public class UserRepository implements ClassLoaderRepository {
    @Override
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        return null;
    }

    @Override
    public Class<?> loadClassWithout(ClassLoader exclude, String className) throws ClassNotFoundException {
        return null;
    }

    @Override
    public Class<?> loadClassBefore(ClassLoader stop, String className) throws ClassNotFoundException {
        return null;
    }
    // Custom queries can be added here
}