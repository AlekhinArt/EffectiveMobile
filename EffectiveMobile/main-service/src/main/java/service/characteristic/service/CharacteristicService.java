package service.characteristic.service;

import service.characteristic.model.Characteristic;

public interface CharacteristicService {
    void createCharacteristic(Characteristic characteristic);

    void changeCharacteristic(Characteristic characteristic);

    void deleteCharacteristic(Characteristic characteristic);
}
