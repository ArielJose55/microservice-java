package co.com.ajac.ports;

import io.vavr.control.Option;

public interface PropertyCommunicator {

	Option<Integer> findCommonPropertyWithThisId(Integer id);
}
