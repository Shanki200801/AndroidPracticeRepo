1. Dependencies and syntax for media player

```java
implementation "androidx.media3:media3-exoplayer:1.1.1"
implementation "androidx.media3:media3-exoplayer-dash:1.1.1"
implementation "androidx.media3:media3-ui:1.1.1"

compileOptions {
  targetCompatibility JavaVersion.VERSION_1_8
}

<uses-permission android:name="android.permission.INTERNET" />

<androidx.media3.ui.PlayerView/>
android:usesCleartextTraffic="true"

ExoPlayer player = new ExoPlayer.Builder(context).build();
PlayerView playerView = findViewById(R.id.media_player);

playerView.setPlayer(player);

MediaItem mediaItem = MediaItem.fromUri(Uri.parse(videoUri));

player.setMediaItem(mediaItem);

player.prepare();

player.play();
player.pause();
player.seekTO();

```

2. Dependencies for splash screen

```java
implementation 'androidx.core:core-splashscreen:1.0.1'
```

3. Splash screen theme changes

```java
 <item name="android:windowSplashScreenAnimatedIcon">@drawable/bread</item>
```

4. Intents syntax

```java
Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/implicit-and-explicit-intents-in-android-with-examples/"));
startActivity(intent);

Intent intent2 = new Intent(this, SecondActivity.class);
startActivity(intent2)
```

5. Calculator, usual onclick syntax

```java
onCreate{
button.setOnClickListener(this::onClick);
}
(remember to implement View.OnClickListener along with extends AppCompat..)
@Override
public void onClick(View view){
    int id = view.getId();
}
```

```java
button.setOnclickListener(new View.setOnClickLister(){
    @Override
    public void onClick(View view){
        ...
    }
})
```

6. Graphical primitives

```java
public class MainActivity extends AppCompatActivity {

        DemoView demoview;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            demoview = new DemoView(this);
            setContentView(demoview);
        }

        private class DemoView extends View {
            public DemoView(Context context) {
                super(context);
            }

            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.WHITE);
                canvas.drawPaint(paint);

                paint.setColor(Color.BLUE);
                paint.setAntiAlias(true);
                canvas.drawRect(100, 150, 700, 800, paint);
                canvas.rotate(90);
                canvas.drawCircle(250,400, 80,paint);
                paint.setColor(Color.BLACK);
                paint.setTextSize(80);
                canvas.drawText("Bot behaviour", 150, 900, paint);

            }
        }
    }

```

7. Menu

```xml
<menu>
    <item
    android:id = "@+/id1"
    android:title = ""
    android:icon = "@drawable/"
    >
    <!--for sub menus -->
    <menu>
        <item ... />
    </menu>
    </item>
</menu>
```

under main class

```java
 @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.demo, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT)
                .show();
        return true;
    }
```

8. Shared preferences

```java
    Context context = this;
    SharedPreferences sharedPref = context.getSharedPreferences(
        "name_of_dict", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString("key","value");
    editor.putInt("key","value");

    String s = sharedPref.getString("key","default value");
```

9. Maps

```java
 
    SupportMapFragment supportMapFragment; 
    FusedLocationProviderClient fusedLocationProviderClient; 
 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
        
getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
WindowManager.LayoutParams.FLAG_FULLSCREEN); 
 
        supportMapFragment = (SupportMapFragment) 
getSupportFragmentManager().findFragmentById(R.id.google_map); 
        fusedLocationProviderClient = (FusedLocationProviderClient) 
LocationServices.getFusedLocationProviderClient(this); 
 
        
Dexter.withContext(getApplicationContext()).withPermission(android.Ma
nifest.permission.ACCESS_FINE_LOCATION) 
                .withListener(new PermissionListener() { 
                    @Override 
                    public void 
onPermissionGranted(PermissionGrantedResponse 
permissionGrantedResponse) { 

                        getCurrentLocation(); 
                    } 
 
                    @Override 
                    public void 
onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) 
{ 
 
                    } 
 
                    @Override 
                    public void 
onPermissionRationaleShouldBeShown(PermissionRequest 
permissionRequest, PermissionToken permissionToken) { 
 
                        permissionToken.continuePermissionRequest(); 
                    } 
                }).check(); 
 
    } 
 
    public void getCurrentLocation() { 
 
        if (ActivityCompat.checkSelfPermission(this, 
android.Manifest.permission.ACCESS_FINE_LOCATION) != 
PackageManager.PERMISSION_GRANTED && 
ActivityCompat.checkSelfPermission(this, 
android.Manifest.permission.ACCESS_COARSE_LOCATION) != 
PackageManager.PERMISSION_GRANTED) { 
 
            return; 
        } 
        Task<Location> task = 
fusedLocationProviderClient.getLastLocation(); 
        task.addOnSuccessListener(new OnSuccessListener<Location>() { 
            @Override 
            public void onSuccess(Location location) { 
                supportMapFragment.getMapAsync(new 
OnMapReadyCallback() { 
                    @Override 
                    public void onMapReady(@NonNull GoogleMap 
googleMap) { 
                        if(location!=null){ 
                            LatLng latLng = new 
LatLng(location.getLatitude(), location.getLongitude()); 
                            MarkerOptions markerOptions = new 
MarkerOptions().position(latLng).title("Current Location"); 
                            googleMap.addMarker(markerOptions); 
                            
googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15))
; 
                        } 
                        else{ 
                            Toast.makeText(MainActivity.this, "Please 
turn your location permissions on", Toast.LENGTH_SHORT).show(); 
                        } 
                    } 
                }); 
            } 
        }); 
    } 
}
```
```xml
<RelativeLayout 
xmlns:android="http://schemas.android.com/apk/res/android" 
    xmlns:app="http://schemas.android.com/apk/res-auto" 
    xmlns:tools="http://schemas.android.com/tools" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent" 
    tools:context=".MainActivity"> 
     
    <fragment 
        android:id="@+id/google_map" 
        android:layout_width="match_parent" 
        android:layout_height="match_parent" 
        
android:name="com.google.android.gms.maps.SupportMapFragment"/> 
</RelativeLayout>
```

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android" 
    xmlns:tools="http://schemas.android.com/tools"> 
 
    <uses-permission android:name="android.permission.INTERNET"/> 
    <uses-permission 
android:name="android.permission.ACCESS_COARSE_LOCATION"/> 
    <uses-permission 
android:name="android.permission.ACCESS_FINE_LOCATION"/> 
    <application 
        android:allowBackup="true" 
        android:dataExtractionRules="@xml/data_extraction_rules" 
        android:fullBackupContent="@xml/backup_rules" 
        android:icon="@mipmap/ic_launcher" 
        android:label="@string/app_name" 
        android:roundIcon="@mipmap/ic_launcher_round" 
        android:supportsRtl="true" 
        android:theme="@style/Theme.AndroidMap" 
        tools:targetApi="31"> 
 
        <meta-data 
            android:name="com.google.android.geo.API_KEY" 
            android:value="AIzaSyDuWkGlIv4paYtnenJbhqtdl10Im0Wt16Q"/> 
        <activity 
            android:name=".MainActivity" 
            android:exported="true"> 
            <intent-filter> 
                <action android:name="android.intent.action.MAIN" /> 
                <category 
android:name="android.intent.category.LAUNCHER" /> 
            </intent-filter> 
        </activity> 
    </application> 
</manifest> 

 
```
10. SQLite
