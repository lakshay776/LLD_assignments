class FakeDbRepository implements StudentRepository {
    private final FakeDb db;

    FakeDbRepository(FakeDb db){
        this.db = db;
    }

    public void save(StudentRecord rec){
        db.save(rec);
    }

    public int count(){
        return db.count();
    }
}