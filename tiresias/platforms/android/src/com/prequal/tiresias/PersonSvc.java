package com.prequal.tiresias;

import com.prequal.tiresias.integration.CardChannel;

public interface PersonSvc {
    ExtendedPerson readData(CardChannel cardChannel) throws ReadException;
}
