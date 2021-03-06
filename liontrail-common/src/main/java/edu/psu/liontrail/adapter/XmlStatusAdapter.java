package edu.psu.liontrail.adapter;

import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class XmlStatusAdapter extends XmlAdapter<JaxRsStatusAdapterType, Status> {

  @Override
  public JaxRsStatusAdapterType marshal(Status status) throws Exception {
    return new JaxRsStatusAdapterType(status);
  }

  @Override
  public Status unmarshal(JaxRsStatusAdapterType adapterType) throws Exception {
    return Status.fromStatusCode(adapterType.getCode());
  }

}
