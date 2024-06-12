package com.example.BookApp.scheduler.service;
import com.example.BookApp.scheduler.model.Stream;
import com.example.BookApp.scheduler.repository.StreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StreamService {
    @Autowired
    private StreamRepository streamRepository;

    public Stream saveStream(Stream stream){
        return streamRepository.save(stream);
    }

    // Retrieve all Streams
    public List<Stream> getAllStreams() {
        return streamRepository.findAll();
    }

    // Retrieve a Stream by ID
    public Optional<Stream> getStreamById(Long id) {
        return streamRepository.findById(id);
    }

    // Delete a Stream by ID
    public void deleteStreamById(Long id) {
        streamRepository.deleteById(id);
    }

    
}
