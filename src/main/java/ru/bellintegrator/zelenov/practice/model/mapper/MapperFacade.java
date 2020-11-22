package ru.bellintegrator.zelenov.practice.model.mapper;

import java.util.List;

/**
 * Фасад для преобразования View объектов в объекты Entity и обратно
 */
public interface MapperFacade {

    /**
     *  Преобразование исходного объекта в целевой
     *
     * @param sourceObj    исходный объект
     * @param destObjClass класс, в который нужно преобразовать объект
     * @param <S>          тип исходного объекта
     * @param <D>          тип целевого объекта
     * @return             экземпляр целевого объекта с данными исходного
     */
    <S, D> D map(S sourceObj, Class<D> destObjClass);

    /**
     * Запись занных из исходного объекта в целевой
     *
     * @param sourceObj исходный объект
     * @param destObj   целевой объект
     * @param <S>       тип исходного объекта
     * @param <D>       тип целевого объекта
     */
    <S, D> void map(S sourceObj, D destObj);

    /**
     * Преобразование коллекции исходных оъектов в коллекцию целевых объектов
     *
     * @param source            коллекция исходных объектов
     * @param destinationClass  класс целевого объекта
     * @param <S>               тип исходного объекта
     * @param <D>               тип целевого объекта
     * @return                  коллекция целевых объектов
     */
    <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass);
}
