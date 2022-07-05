<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * Class Product
 *
 * @property $id
 * @property $img
 * @property $preu
 * @property $procedencia
 * @property $kcud
 * @property $kg100g
 * @property $greixos
 * @property $carbohidrats
 * @property $proteines
 * @property $created_at
 * @property $updated_at
 *
 * @package App
 * @mixin \Illuminate\Database\Eloquent\Builder
 */
class Product extends Model
{
    
    static $rules = [
		'img' => 'required',
		'preu' => 'required',
		'procedencia' => 'required',
		'kcud' => 'required',
		'kg100g' => 'required',
		'greixos' => 'required',
		'carbohidrats' => 'required',
		'proteines' => 'required',
    'bought' => 'bought',
    ];

    protected $perPage = 20;

    /**
     * Attributes that should be mass-assignable.
     *
     * @var array
     */
    protected $fillable = ['img','preu','procedencia','kcud','kg100g','greixos','carbohidrats','bought'];



}
