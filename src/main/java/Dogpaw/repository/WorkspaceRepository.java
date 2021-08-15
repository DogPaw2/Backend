package Dogpaw.repository;

import Dogpaw.domain.Workspace;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import static Dogpaw.domain.QWorkspace.workspace;

@Repository
public class WorkspaceRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    @Autowired
    public WorkspaceRepository(EntityManager em) {
        this.em = em;
        queryFactory = new JPAQueryFactory(em);
    }

    public void save(Workspace _workspace) { em.persist(_workspace); }

    public Long delete(Workspace _workspace){
        long execute = queryFactory
                .delete(workspace)
                .where(workspace.eq(_workspace))
                .execute();

        return execute;
    }

    public Workspace findById(Long _id){
        Workspace result = queryFactory
                .select(workspace)
                .from(workspace)
                .where(workspace.id.eq(_id))
                .fetchOne();

        return result;
    }

}
