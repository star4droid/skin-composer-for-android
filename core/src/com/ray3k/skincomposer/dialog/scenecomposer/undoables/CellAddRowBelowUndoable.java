package com.ray3k.skincomposer.dialog.scenecomposer.undoables;

import com.ray3k.skincomposer.dialog.scenecomposer.DialogSceneComposer;
import com.ray3k.skincomposer.dialog.scenecomposer.DialogSceneComposerModel;

public class CellAddRowBelowUndoable implements SceneComposerUndoable {
    private DialogSceneComposerModel.SimCell cell;
    private DialogSceneComposerModel.SimCell newCell;
    private DialogSceneComposer dialog;
    private DialogSceneComposerModel.SimTable table;
    
    public CellAddRowBelowUndoable() {
        dialog = DialogSceneComposer.dialog;
        
        cell = (DialogSceneComposerModel.SimCell) dialog.simActor;
        table = (DialogSceneComposerModel.SimTable) cell.parent;
        
        newCell = new DialogSceneComposerModel.SimCell();
        newCell.column = 0;
        newCell.row = cell.row + 1;
        newCell.parent = table;
    }
    
    @Override
    public void undo() {
        table.cells.removeValue(newCell, true);
        
        for (var currentCell : table.cells) {
            if (currentCell.row >= newCell.row) {
                currentCell.row--;
            }
        }
        
        table.sort();
        
        if (dialog.simActor != cell) {
            dialog.simActor = cell;
            dialog.populateProperties();
        }
        dialog.populatePath();
    }
    
    @Override
    public void redo() {
        for (var currentCell : table.cells) {
            if (currentCell.row >= newCell.row) {
                currentCell.row++;
            }
        }
    
        table.cells.add(newCell);
        table.sort();
        
        if (dialog.simActor != newCell) {
            dialog.simActor = newCell;
            dialog.populateProperties();
        }
        dialog.populatePath();
    }
    
    @Override
    public String getRedoString() {
        return "Redo \"Add Row Below Cell\"";
    }
    
    @Override
    public String getUndoString() {
        return "Undo \"Add Row Below Cell\"";
    }
}
