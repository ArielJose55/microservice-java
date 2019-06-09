package co.com.ajac.ports;

import io.vavr.control.Option;

public interface DeviceCommunicator {

	Option<Integer> verifyDeviceExistence(String serial);
}
