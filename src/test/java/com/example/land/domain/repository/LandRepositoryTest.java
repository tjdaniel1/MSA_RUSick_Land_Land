package com.example.land.domain.repository;

import com.example.land.domain.entity.Land;
import jakarta.transaction.Transactional;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LandRepositoryTest {
    @Autowired
    private LandRepository landRepository;
    void 초기_데이터_입력(){
        UUID owner1 = UUID.randomUUID();
        UUID owner2 = UUID.randomUUID();
        UUID owner3 = UUID.randomUUID();
        UUID owner4 = UUID.randomUUID();
        UUID owner5 = UUID.randomUUID();
        UUID owner6 = UUID.randomUUID();
        Land land1 = Land.builder().ownerId(owner1).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land2 = Land.builder().ownerId(owner2).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land3 = Land.builder().ownerId(owner3).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land4 = Land.builder().ownerId(owner4).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land5 = Land.builder().ownerId(owner5).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land6 = Land.builder().ownerId(owner6).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land7 = Land.builder().ownerId(owner1).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land8 = Land.builder().ownerId(owner2).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land9 = Land.builder().ownerId(owner2).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land10 = Land.builder().ownerId(owner4).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();

        landRepository.save(land1);
        landRepository.save(land2);
        landRepository.save(land3);
        landRepository.save(land4);
        landRepository.save(land5);
        landRepository.save(land6);
    }

    @Test
    @Transactional
    void findByOwnerIdIn() {
        UUID owner1 = UUID.randomUUID();
        UUID owner2 = UUID.randomUUID();
        UUID owner3 = UUID.randomUUID();
        UUID owner4 = UUID.randomUUID();
        UUID owner5 = UUID.randomUUID();
        UUID owner6 = UUID.randomUUID();
        Land land1 = Land.builder().ownerId(owner1).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land2 = Land.builder().ownerId(owner2).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land3 = Land.builder().ownerId(owner3).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land4 = Land.builder().ownerId(owner4).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land5 = Land.builder().ownerId(owner5).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land6 = Land.builder().ownerId(owner6).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land7 = Land.builder().ownerId(owner1).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land8 = Land.builder().ownerId(owner2).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land9 = Land.builder().ownerId(owner2).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();
        Land land10 = Land.builder().ownerId(owner4).landAddress("t").landArea("t").landBuiltDate(LocalDateTime.now()).landCategory(1).landName("t").landPrice(10000L).landYN(false).ownerName("t").build();

        landRepository.save(land1);
        landRepository.save(land2);
        landRepository.save(land3);
        landRepository.save(land4);
        landRepository.save(land5);
        landRepository.save(land6);
        landRepository.save(land7);
        landRepository.save(land8);
        landRepository.save(land9);
        landRepository.save(land10);

        Set<UUID> set = new HashSet<>();
        set.add(owner1);
        set.add(owner2);
        set.add(owner3);
        set.add(UUID.randomUUID());
        set.add(UUID.randomUUID());
        List<Object[]> list = landRepository.findByOwnerIdIn(set);
        System.out.println(set);
        System.out.println(list.size());
        for(Object[] o : list) {
            System.out.println(o[0] + " " + o[1]);
        }
        List<Land> ll = landRepository.findAll();
        System.out.println(ll.size());
    }
}