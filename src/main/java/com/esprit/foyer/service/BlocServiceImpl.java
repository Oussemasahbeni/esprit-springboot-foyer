package com.esprit.foyer.service;

import com.esprit.foyer.entity.Bloc;
import com.esprit.foyer.repository.BlocRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {

    private final BlocRepository blocRepository;

    @Override
    public Bloc addBloc(Bloc bloc) {
        return this.blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        Bloc existingBloc = this.blocRepository.findById(bloc.getId()).orElse(null);
        if (existingBloc == null) {
            return null;
        }
        return this.blocRepository.save(bloc);
    }

    @Override
    public void deleteById(Long id) {
        this.blocRepository.deleteById(id);
    }

    @Override
    public Bloc findById(Long id) {
        return this.blocRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bloc> findAll() {
        return this.blocRepository.findAll();
    }

    @Override
    public List<Bloc> addBatchBloc(List<Bloc> blocs) {
        return this.blocRepository.saveAll(blocs);
    }
}