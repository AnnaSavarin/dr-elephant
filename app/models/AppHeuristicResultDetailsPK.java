package models;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by a.savarin on 25/09/2017.
 */

@Embeddable
public class AppHeuristicResultDetailsPK extends Model implements Serializable {

    private static final long serialVersionUID = 4L;

    public static final int NAME_LIMIT = 128;

    @Column(name = "yarn_app_heuristic_result_id", nullable = false)
    public AppHeuristicResult yarnAppHeuristicResult;

    @Column(name = "name", length = NAME_LIMIT, nullable = false)
    public String name;

    public AppHeuristicResultDetailsPK(AppHeuristicResult yarnAppHeuristicResultId, String name) {
        this.yarnAppHeuristicResult = yarnAppHeuristicResultId;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final AppHeuristicResultDetailsPK other = (AppHeuristicResultDetailsPK) obj;
        if (this.yarnAppHeuristicResult != other.yarnAppHeuristicResult) {
            return false;
        }

        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 12;
        hash = 36 * hash + (this.yarnAppHeuristicResult != null ? this.yarnAppHeuristicResult.hashCode() : 0);
        hash = 36 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

}
