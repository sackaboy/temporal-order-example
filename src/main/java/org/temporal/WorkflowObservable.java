package org.temporal;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.jboss.logging.Logger;
import org.temporal.Activity.ActivityOrderNewProductImpl;
import org.temporal.Workflow.Define.OrderProduct;
import org.temporal.Workflow.Define.OrderProductImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class WorkflowObservable {

    private static final Logger LOG = Logger.getLogger(WorkflowObservable.class);

    private WorkflowClient client;
    private WorkerFactory factory;

    void onStart(@Observes StartupEvent event){
        LOG.info("****************** On start: Run workflow ****************");

        WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();
        client = WorkflowClient.newInstance(service);
        factory = WorkerFactory.newInstance(client);
        Worker worker = factory.newWorker(OrderProduct.QUEUE_NAME);
        worker.registerWorkflowImplementationTypes(OrderProductImpl.class);
        worker.registerActivitiesImplementations(new ActivityOrderNewProductImpl());
        LOG.info("Start WorkflowService ");
        factory.start();
    }

    void onStop(@Observes ShutdownEvent event){
        factory.shutdown();
        LOG.info("****************** On stop: stop workflow ****************");
    }
    public WorkflowClient getClient(){
        return client;
    }
}
