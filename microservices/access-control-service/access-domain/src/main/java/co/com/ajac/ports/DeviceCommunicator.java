package co.com.ajac.ports;

import io.vavr.control.Option;

public interface DeviceCommunicator {

	Option<Integer> verifyCommonPropertyExistence(String serial);
}
