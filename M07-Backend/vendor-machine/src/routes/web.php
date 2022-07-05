<?php
//use App\Http\Controllers\ProductController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\LoginController;
use App\Http\Controllers\ProductController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

//Route::resource('products',ProductController::class);

Route::view('/','welcome');
Route::view('login','login')->name('login')->middleware('guest');
Route::view('shop','shop')->middleware('auth');


Route::post('/login', [LoginController::class, 'login']);

Route::put('/login', [LoginController::class, 'logout']);

Route::get('/products', [ProductController::class, 'allProducts']);
// function(){
//     $listado=App\Models\Product::all();
//     return view('shop', array('products'=>$listado)); 
// });

Route::get('/product/{id}', [ProductController::class, 'singleProduct']);

Route::get('/product/buy/{id}', [ProductController::class, 'buyProduct']);