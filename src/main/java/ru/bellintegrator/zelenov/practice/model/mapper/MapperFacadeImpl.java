package ru.bellintegrator.zelenov.practice.model.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapperFacadeImpl implements MapperFacade {
    private final MapperFactory mapperFactory;

    @Autowired
    public MapperFacadeImpl(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    @Override
    public <S, D> D map(S sourceObj, Class<D> destObjClass) {
        return null;
    }

    @Override
    public <S, D> void map(S sourceObj, D destObj) {

    }

    @Override
    public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
        return null;
    }
}
