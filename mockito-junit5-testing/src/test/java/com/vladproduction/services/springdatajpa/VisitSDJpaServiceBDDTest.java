package com.vladproduction.services.springdatajpa;

import com.vladproduction.model.Visit;
import com.vladproduction.repositories.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceBDDTest {

    @Mock
    VisitRepository visitRepository;
    @InjectMocks
    VisitSDJpaService service;

    @Test
    void findAll() {
        //given
        Visit visit = new Visit();
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);
        given(visitRepository.findAll()).willReturn(visits);
        //when
        Set<Visit> foundVisits = service.findAll();
        //then
        assertThat(foundVisits).hasSize(1);
        assertThat(foundVisits).contains(visit);
        then(visitRepository).should().findAll();
    }

    @Test
    void findById() {
        //given
        Visit visit = new Visit();
        given(visitRepository.findById(anyLong())).willReturn(Optional.of(visit));
        //when
        Visit foundVisit = service.findById(1L);
        //then
        assertThat(foundVisit).isNotNull();
        then(visitRepository).should().findById(anyLong());
    }

    @Test
    void save() {
        //given
        Visit visit = new Visit();
        given(visitRepository.save(any(Visit.class))).willReturn(visit);
        //when
        Visit savedVisit = service.save(new Visit());
        //then
        assertThat(savedVisit).isNotNull();
        then(visitRepository).should().save(any(Visit.class));
    }

    @Test
    void delete() {
        //given
        Visit visit = new Visit();
        //when
        service.delete(visit);
        //then
        then(visitRepository).should().delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        //given

        //when
        service.deleteById(1L);
        //then
        then(visitRepository).should().deleteById(anyLong());
    }
}