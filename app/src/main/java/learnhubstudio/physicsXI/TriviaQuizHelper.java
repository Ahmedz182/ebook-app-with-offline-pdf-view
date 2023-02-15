package learnhubstudio.physicsXI;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


class TriviaQuizHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "TQuiz.db";

    //If you want to add more questions or wanna update table values
    //or any kind of modification in db just increment version no.
    private static final int DB_VERSION = 3;
    //Table name
    private static final String TABLE_NAME = "TQ";
    //Id of question
    private static final String UID = "_UID";
    //Question
    private static final String QUESTION = "QUESTION";
    //Option A
    private static final String OPTA = "OPTA";
    //Option B
    private static final String OPTB = "OPTB";
    //Option C
    private static final String OPTC = "OPTC";
    //Option D
    private static final String OPTD = "OPTD";
    //Answer
    private static final String ANSWER = "ANSWER";
    //So basically we are now creating table with first column-id , sec column-question , third column -option A, fourth column -option B , Fifth column -option C , sixth column -option D , seventh column - answer(i.e ans of  question)
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + OPTD + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";
    //Drop table query
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    TriviaQuizHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
;    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //OnCreate is called only once
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //OnUpgrade is called when ever we upgrade or increment our database version no
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    void allQuestion() {
        ArrayList<TriviaQuestion> arraylist = new ArrayList<>();

        arraylist.add(new TriviaQuestion("The branch of physics which deals with the ultimate particles of which the matter is composed is:", "Plasma physics", "Atomic physics", "Nuclear physics", "Particle physics", "Particle physics"));
        arraylist.add(new TriviaQuestion("What exactly is a conservative force conserving?","Force","Energy","Velocity","Acceleration","Energy"));
        arraylist.add(new TriviaQuestion("The force that is not one of the conservative forces is","frictional force","gravitational force","electric force","elastic spring force","frictional force"));
        arraylist.add(new TriviaQuestion("A field in which the work is done in a moving body along a closed path is zero is called.","Electric field","Conservative field","Electromagnetic field","None of the above","Conservative field"));
        arraylist.add(new TriviaQuestion("When a force is parallel to the direction of motion of the body, then work done on the body is.","zero","minimum","infinity","maximum","maximum"));
        arraylist.add(new TriviaQuestion(" Which of the following types of force can do no work on the particle on which it acts?","Frictional force","Gravitational force","Elastic force","Centripetal force","Centripetal force"));
        arraylist.add(new TriviaQuestion("For equilibrium, the net moment acting on the body by various conservative forces is _____:","One","Two","Three","Zero","Zero"));
        arraylist.add(new TriviaQuestion("The conservative frictional force always acts ____________ to the surface of the application of the friction.","Tangential","Perpendicular","Parallel","Normal","Tangential"));
        arraylist.add(new TriviaQuestion("What does Newton’s third law states for the conservative forces?","The rate of change of momentum is equal to the force applied","For every reaction, there is an opposite reaction","The body tends to be rotated if the force is applied tangentially","The body is rest until a force is applied","For every reaction, there is an opposite reaction"));
        arraylist.add(new TriviaQuestion("If any external conservative force also is applied on the distributed loading then?","The net force will act at the centroid of the structure only","The net load will not be formed as all the forces will be canceled","The net force will act on the base of the loading horizontally","The net force will not be considered, there would be a net force of the distribution, rest will be the external forces","The net force will not be considered, there would be a net force of the distribution, rest will be the external forces"));
        arraylist.add(new TriviaQuestion("A conservative force is dependent only on :","Position of the objects","Position of the forces","Position of the path taken","None of the above","Position of the objects"));

        this.addAllQuestions(arraylist);

    }


    private void addAllQuestions(ArrayList<TriviaQuestion> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (TriviaQuestion question : allQuestions) {
                values.put(QUESTION, question.getQuestion());
                values.put(OPTA, question.getOptA());
                values.put(OPTB, question.getOptB());
                values.put(OPTC, question.getOptC());
                values.put(OPTD, question.getOptD());
                values.put(ANSWER, question.getAnswer());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }


    List<TriviaQuestion> getAllOfTheQuestions() {

        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);


        while (cursor.moveToNext()) {
            TriviaQuestion question = new TriviaQuestion();
            question.setId(cursor.getInt(0));
            question.setQuestion(cursor.getString(1));
            question.setOptA(cursor.getString(2));
            question.setOptB(cursor.getString(3));
            question.setOptC(cursor.getString(4));
            question.setOptD(cursor.getString(5));
            question.setAnswer(cursor.getString(6));
            questionsList.add(question);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }
}
