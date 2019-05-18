package co.com.ajac.ports;

import io.vavr.control.Option;

public interface PropertyCommunicator {

	Option<Integer> checkExistenceProperty(Integer code, String property);
}
