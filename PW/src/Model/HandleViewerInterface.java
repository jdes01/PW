package Model;

import Model.Viewer;

public interface HandleViewerInterface {
    
    void createViewer(){}

    void deleteViewer(Viewer viewer){}

    Viewer getViewer(Integer id){}

    void updateViewer(Viewer viewer){}
}
